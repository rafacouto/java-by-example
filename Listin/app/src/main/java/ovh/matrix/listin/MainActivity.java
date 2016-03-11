package ovh.matrix.listin;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnCargar;
    ListView lstContactos;

    ArrayAdapter<String> contactAdapter;

    ArrayList<String> contactNames = new ArrayList<>();
    ArrayList<String> contactPhones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactNames);
        lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(contactAdapter);
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                actionContact(position);
            }
        });

        btnCargar = (Button) findViewById(R.id.btnCargar);
        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadContacts();
            }
        });
    }

    private void loadContacts() {

        ContentResolver contentResolver = getContentResolver();

        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                new String[]{
                        ContactsContract.Contacts.DISPLAY_NAME,
                        ContactsContract.Contacts._ID,
                },
                null,
                new String[] { },
                null);


        if (cursor.moveToFirst()) {
            do {

                String displayName = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                contactNames.add(displayName);

                String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                Cursor phones = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,
                        null, null);

                if (cursor.moveToFirst()) {

                    String number = phones.getString(phones.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER));
                    contactPhones.add(number);
                }
                phones.close();

            } while (cursor.moveToNext());
        }

    }

    private void actionContact(int position) {

        String phone = contactPhones.get(position);

        if (phone != null) {

            Toast.makeText(this, phone, Toast.LENGTH_LONG).show();
        }
    }
}
