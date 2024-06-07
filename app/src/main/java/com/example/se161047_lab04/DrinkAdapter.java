package com.example.se161047_lab04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DrinkAdapter extends BaseAdapter {
    private Context context;
    private int layout;

    private List<Drink> drinkList;

    public DrinkAdapter(Context context, int layout, List<Drink> drinkList) {
        this.context = context;
        this.layout = layout;
        this.drinkList = drinkList;
    }

    @Override
    public int getCount() {
        return drinkList.size();
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

        TextView name = convertView.findViewById(R.id.nameDrink);
        TextView des = convertView.findViewById(R.id.desDrink);
        ImageView img = convertView.findViewById(R.id.imageDrink);

        Drink drink =drinkList.get(position);

        name.setText(drink.getDrinkName());
        des.setText(drink.getDrinkDes());
        img.setImageResource(drink.getImage());


        return convertView;
    }
}
