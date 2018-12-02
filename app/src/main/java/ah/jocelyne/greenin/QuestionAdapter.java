package ah.jocelyne.greenin;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joc on 4/5/2018.
 */

public class QuestionAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<String> questions;
    private HashMap<String, ArrayList<String>> answers;

    public QuestionAdapter(Context c, ArrayList<String> questionList, HashMap<String, ArrayList<String>> answerList) {
        context = c;
        questions = questionList;
        answers = answerList;
    }

    @Override
    public int getGroupCount() {
        return questions.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return answers.get(questions.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return answers.get(questions.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int position, boolean b, View view, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.list_parent, null);

        TextView titleTV = view.findViewById(R.id.questionTextView);
        titleTV.setTypeface(null, Typeface.BOLD);
        titleTV.setText(questions.get(position));

//        ImageView img = view.findViewWithTag(R.id.img);
//        if(b) {
//            img.setImageResource(R.drawable.group_down);
//        }
//        else {
//            img.setImageResource(R.drawable.group_up);
//        }

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup child) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.list_child, null);

        TextView answerTV = view.findViewById(R.id.answerTextView);
        String answer = (String) getChild(i, i1);
        answerTV.setText(answer);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}