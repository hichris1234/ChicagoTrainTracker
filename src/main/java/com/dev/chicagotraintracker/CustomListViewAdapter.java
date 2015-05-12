package com.dev.chicagotraintracker;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomListViewAdapter extends BaseAdapter {

	   private LayoutInflater inflater;
	   private ArrayList<CustomObject> objects;

	   private class ViewHolder {
	      TextView textView1;
	      TextView textView2;
	      TextView textView3;
	   }

	   public CustomListViewAdapter(Context context, ArrayList<CustomObject> objects) {
	      inflater = LayoutInflater.from(context);
	      this.objects = objects;
	   }

	   public int getCount() {
	      return objects.size();
	   }

	   public CustomObject getItem(int position) {
	      return objects.get(position);
	   }

	   public long getItemId(int position) {
	      return position;
	   }


public View getView(int position, View convertView, ViewGroup parent) {
	      ViewHolder holder = null;
	      if(convertView == null) {
	          holder = new ViewHolder();
	          convertView = inflater.inflate(R.layout.list_item, parent, false);
	          holder.textView1 = (TextView) convertView.findViewById(R.id.title);
	          holder.textView2 = (TextView) convertView.findViewById(R.id.desc);
	          holder.textView3 = (TextView) convertView.findViewById(R.id.time);
	          convertView.setTag(holder);
	      } else {
	         holder = (ViewHolder) convertView.getTag();
	      }
	      holder.textView1.setText(objects.get(position).getProp1());
	      holder.textView2.setText(objects.get(position).getProp2());
	      holder.textView3.setText(objects.get(position).getProp3());
	      return convertView;
	   }
	}