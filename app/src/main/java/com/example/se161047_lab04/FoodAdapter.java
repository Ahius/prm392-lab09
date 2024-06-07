package com.example.se161047_lab04;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private int layout;

    private List<Food> foodList;

    public FoodAdapter(Context context, int layout, List<Food> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(layout, null);

        TextView name = convertView.findViewById(R.id.nameFruit);
        TextView des = convertView.findViewById(R.id.desFruit);
        ImageView img = convertView.findViewById(R.id.imageFruit);

        Food food =foodList.get(position);

        name.setText(food.getFoodName());
        des.setText(food.getFoodDes());
//        img.setImageResource(food.getImage());
        Picasso.get().load(food.getImgae()).into(img);


        return convertView;
    }
}