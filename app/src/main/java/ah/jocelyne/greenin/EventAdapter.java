package ah.jocelyne.greenin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by joc on 4/9/2018.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private ArrayList<Event> events;
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public EventAdapter(ArrayList<Event> list, Context context) {
        events = list;
        this.context = context;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class EventViewHolder extends RecyclerView.ViewHolder {

        public static CardView cardView;
        public static ImageView imageView;
        public static TextView date;
        public static TextView day;
        public static TextView name;
        public static TextView location;
        public static TextView time;

        EventViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.my_card_view);
            imageView = view.findViewById(R.id.imageView);
            date = view.findViewById(R.id.date);
            day = view.findViewById(R.id.day);
            name = view.findViewById(R.id.name);
            location = view.findViewById(R.id.location);
            time = view.findViewById(R.id.time);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_row, parent, false);
        EventViewHolder vh = new EventViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final EventViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final String img_url = events.get(position).getImg_url();
        final String date = events.get(position).getDate();
        final String day = events.get(position).getDay();
        final String name = events.get(position).getName();
        final String location = events.get(position).getLocation();
        final String time = events.get(position).getTime();
        final String desciption = events.get(position).getDescription();

        Glide.with(context).load(img_url).into(holder.imageView); //WOWOWOWOWOWOWOWOWOW Nader got skills
        holder.date.setText(date);
        holder.day.setText(day);
        holder.name.setText(name);
        holder.location.setText(location);
        holder.time.setText(time);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, EventDetail.class);

                i.putExtra("img_url", img_url);
                i.putExtra("date", date);
                i.putExtra("day", day);
                i.putExtra("name", name);
                i.putExtra("location", location);
                i.putExtra("time", time);
                i.putExtra("description", desciption);

                context.startActivity(i);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return events.size();
    }
}