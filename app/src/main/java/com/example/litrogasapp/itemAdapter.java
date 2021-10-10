package com.example.litrogasapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.itemAdapterVh> implements Filterable {

    public List<ItemModel> itemModelList = new ArrayList<>();
    public List<ItemModel> getItemModelListFilter = new ArrayList<>();
    public Context context;
    public itemClickListener clickListener;

    public itemAdapter(List<ItemModel> itemModels, Context context, itemClickListener itemClickListener) {
        this.itemModelList = itemModels;
        this.getItemModelListFilter = itemModels;
        this.context = context;
        this.clickListener = itemClickListener;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0){
                    filterResults.values = getItemModelListFilter;
                    filterResults.count = getItemModelListFilter.size();
                }else{
                    String searchStr = constraint.toString().toLowerCase();
                    List<ItemModel> itemModels = new ArrayList<>();
                    for (ItemModel itemModel: getItemModelListFilter){
                        if (itemModel.getTitle().toLowerCase().contains(searchStr)){
                            itemModels.add(itemModel);
                        }
                    }

                    filterResults.values = itemModels;
                    filterResults.count = itemModels.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                itemModelList = (List<ItemModel>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

    public interface itemClickListener {
        void selectedItem(ItemModel itemModel);
    }




    @NonNull
    @Override
    public itemAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_items,parent,false);
        return new itemAdapterVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapter.itemAdapterVh holder, int position) {
        ItemModel itemModel = itemModelList.get(position);
        String itemTitle = itemModel.getTitle();
        String itemQ = itemModel.getQuantity();
        String itemP = itemModel.getPrice();
        String itemA = itemModel.getAvailability();
        String itemRowOne = itemTitle;
        String itemRowTwo = itemP + " " + itemA;
        String prefix1 = itemTitle.charAt(0)+""+itemTitle.charAt(1);
        String prefix2 = itemP.charAt(0)+""+itemA.charAt(0);

        holder.itemName.setText(itemRowOne);
        holder.itemQuantity.setText(itemRowTwo);
        holder.itemPrefix.setText(prefix1);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.selectedItem(itemModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public static class itemAdapterVh extends RecyclerView.ViewHolder {

        private TextView itemName;
        private TextView itemPrefix;
        private TextView itemQuantity;

        public itemAdapterVh(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.ritemName);
            itemPrefix = itemView.findViewById(R.id.itemsPrefix);
            itemQuantity = itemView.findViewById(R.id.rquantity);


        }
    }
}
