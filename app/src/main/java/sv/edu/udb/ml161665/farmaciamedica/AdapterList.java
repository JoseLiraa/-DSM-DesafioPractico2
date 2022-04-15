package sv.edu.udb.ml161665.farmaciamedica;

import android.view.ViewGroup;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class AdapterList extends ListAdapter<Order, ItemRecyclerView> {
    public AdapterList(@NotNull DiffUtil.ItemCallback<Order> diffCallback){
        super(diffCallback);
    }
    @Override
    public void onBindViewHolder (ItemRecyclerView item, int position){
        Order actual = getItem(position);
        item.fill(actual.getOrder());
    }
    @Override
    public ItemRecyclerView onCreateViewHolder(ViewGroup father, int ViewType){
        return ItemRecyclerView.create(father);
    }
    static class OrderDiff extends DiffUtil.ItemCallback<Order>{
        @Override
        public boolean areItemsTheSame(@NotNull Order oldItem,@NotNull Order newItem){
            return newItem==oldItem;
        }
        @Override
        public boolean areContentsTheSame(@NotNull Order oldItem,@NotNull Order newItem){

            return Arrays.deepEquals(oldItem.getOrder(),newItem.getOrder());
        }
    }

}
