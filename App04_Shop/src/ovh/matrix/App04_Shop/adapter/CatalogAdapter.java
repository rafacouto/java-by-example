package ovh.matrix.App04_Shop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import ovh.matrix.App04_Shop.model.Catalog;
import ovh.matrix.App04_Shop.model.CatalogItem;

import java.util.List;


/**
 * Created by caligari on 2/29/16.
 */
public class CatalogAdapter extends ArrayAdapter<CatalogItem> {


    private List<CatalogItem> items;

    public CatalogAdapter(Context context, int res, Catalog catalog) {

        super(context, res);
        this.items = catalog.getList();
    }



    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public CatalogItem getItem(int position) { return items.get(position); }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = super.getView(position, convertView, parent);

        if (view instanceof TextView) {

            CatalogItem item = getItem(position);

            String txt = String.format("#%d %s (%.2f €)", item.getId(), item.getName(), item.getPrice());

            ((TextView) view).setText(txt);
        }

        return view;
    }
}
