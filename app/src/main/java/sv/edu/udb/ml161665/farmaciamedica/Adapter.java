package sv.edu.udb.ml161665.farmaciamedica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    Context context;
    List<Data> ListObjets;

    public Adapter(Context context, List<Data> listObjets) {
        this.context = context;
        ListObjets = listObjets;
    }

    @Override
    public int getCount() {
        return ListObjets.size();
    }

    @Override
    public Object getItem(int i) {
        return ListObjets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return ListObjets.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vist = view;

        LayoutInflater inflate = LayoutInflater.from(context);
        vist = inflate.inflate(R.layout.itemlistview, null);

        ImageView image = (ImageView) vist.findViewById(R.id.imageView);
        TextView name = (TextView) vist.findViewById(R.id.textView2);
        TextView price = (TextView) vist.findViewById(R.id.textView);


        name.setText(ListObjets.get(i).getName().toString());
        price.setText(ListObjets.get(i).getPrice().toString());
        image.setImageResource(ListObjets.get(i).getImage());


        return vist;
    }
}
