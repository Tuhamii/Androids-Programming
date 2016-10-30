package com.tuhamii.android.geoquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {


    private static final String EXTRA_ANSWER_IS_TRUE =
    "com.tuhamii.android.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN =
            "com.tuhamii.android.geoquiz.answer_shown";

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mSHowAnswer;


    public static Intent newIntent(Context packageContext,boolean answerIsTrue){
        Intent i = new Intent(packageContext ,CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return i;
    }
    public static boolean wasAnswerShown(Intent results){
        return results.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }

    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

        mSHowAnswer = (Button) findViewById(R.id.show_answer_button);
        mSHowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);

                int cx = mSHowAnswer.getWidth() / 2;
                int cy = mSHowAnswer.getHeight() / 2;
                float radius = mSHowAnswer.getWidth();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Animator anim = ViewAnimationUtils.createCircularReveal(mSHowAnswer,cx,cy,radius,0);
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mAnswerTextView.setVisibility(View.VISIBLE);
                            mSHowAnswer.setVisibility(View.INVISIBLE);
                        }
                    });
                    anim.start();
                }
                else {
                    mAnswerTextView.setVisibility(View.VISIBLE);
                    mSHowAnswer.setVisibility(View.INVISIBLE);
                }

            }

        });
    }
}
