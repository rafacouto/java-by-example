package ovh.matrix.App04_Shop.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import ovh.matrix.App04_Shop.model.CatalogItem;
import ovh.matrix.App04_Shop.model.Order;
import ovh.matrix.App04_Shop.R;

import java.util.List;

public class OrderActivity extends Activity {


    Button btnConfirm;
    Button btnCall;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        btnConfirm = (Button) findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Order order = Order.getInstance();

                // ToDo: mock
                List<CatalogItem> products = order.getCatalog().getList();
                order.setItem(products.get(0).getId(), 2);
                order.setItem(products.get(1).getId(), 4);
                order.setItem(products.get(2).getId(), 1);

                if (order.size() > 0) {

                    composeEmail(
                            new String[]{ "rafacouto@gmail.com" },
                            "New order from your favourite shop",
                            order.toString()
                    );
                }
            }
        });


        btnCall = (Button) findViewById(R.id.btnSupport);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+34 900122312"));
                if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
            }
        });

    }



    public void composeEmail(String[] addresses, String subject, String text) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);

        if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {

            case R.id.mnuMainWeb:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://yourfavouriteshop.com"));
                if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
                break;

            case R.id.mnuMainMap:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:47.6,-122.3"));
                if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
