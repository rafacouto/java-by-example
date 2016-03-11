package ovh.matrix.providerconsumer;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {


    private static final Uri URI = Uri.parse(
            "content://es.pue.agendaamigos.amigoprovider/amigos");

    public static final class Columnas {
        public static final String _ID = "_id";
        public static final String FIRST = "nombre";
        public static final String LAST = "apellido";
        public static final String PHONE = "telefono";
    };

    ArrayAdapter<String> amigosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        amigosAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);

        getListView().setAdapter(amigosAdapter);

        cargarAmigos();
    }

    private void cargarAmigos() {

        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(URI, new String[]{
                Columnas._ID, Columnas.FIRST, Columnas.LAST, Columnas.PHONE
                }, null, null, null);

        c.moveToFirst();
        do {
            String amigo = c.getString(c.getColumnIndex(Columnas.FIRST)) + " " +
                c.getString(c.getColumnIndex(Columnas.LAST));
            amigosAdapter.add(amigo);
        } while (c.moveToNext());
    }
}
