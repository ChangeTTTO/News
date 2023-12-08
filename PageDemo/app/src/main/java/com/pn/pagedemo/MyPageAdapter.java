package com.pn.pagedemo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class MyPageAdapter extends PagingDataAdapter<Student, MyPageAdapter.MyViewHolder> {

    public MyPageAdapter() {
        super(new DiffUtil.ItemCallback<Student>() {
            @Override
            //用于比较两个Student对象是否表示相同的项目（item）
            public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                //检查oldItem的id属性是否等于newItem的id属性。如果它们的id相等则代表相同
                return oldItem.getId()==newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return false;
            }
        });
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
        }
    }

}
