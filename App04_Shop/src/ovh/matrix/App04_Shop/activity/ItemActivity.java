package ovh.matrix.App04_Shop.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import ovh.matrix.App04_Shop.adapter.CatalogAdapter;
import ovh.matrix.App04_Shop.model.Catalog;
import ovh.matrix.App04_Shop.model.CatalogItem;
import ovh.matrix.App04_Shop.R;

public class ItemActivity extends Activity {


    Spinner lstItems;
    EditText txtQuantity;
    Button btnLess;
    Button btnMore;
    CatalogAdapter spinnerAdapter;

    private final Catalog catalog;
    private CatalogItem catalogItem;
    private int quantity;



    public ItemActivity() {

        this.catalog = Catalog.getTestInstance();
        this.catalogItem = null;
    }



    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        //////////

        spinnerAdapter = new CatalogAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.catalog);

        lstItems = (Spinner) findViewById(R.id.lstItems);

        lstItems.setAdapter(spinnerAdapter);

        lstItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                catalogItem = spinnerAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                catalogItem = null;
            }
        });

        //////////

        txtQuantity = (EditText) findViewById(R.id.txtQuantity);

        txtQuantity.setText(Integer.toString(quantity));

        //////////

        btnLess = (Button) findViewById(R.id.btnLess);

        btnLess.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (quantity > 1) quantity--;

                txtQuantity.setText(Integer.toString(quantity));
            }
        });

        //////////

        btnMore = (Button) findViewById(R.id.btnMore);

        btnMore.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                quantity++;

                txtQuantity.setText(Integer.toString(quantity));
            }
        });

        /////////
    }
}
