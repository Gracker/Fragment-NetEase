package com.gracker.tabfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

import com.and.netease.utils.MoveBg;

import fragment_content.Contentfragment;
import fragment_content.TopBarFragment;

public class MainActivity extends Activity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    ImageView img;
    TabHost tabHost;
    FrameLayout bottom_layout;

    int startLeft = 0;
    int paddingLeft = 0;
    int moveWidth;
    // 当Tab发生变化时，改变tab的标签的显示图片
    private OnCheckedChangeListener checkedChangeListener = new OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Contentfragment fragment = (Contentfragment) getFragmentManager()
                    .findFragmentById(R.id.content_fragment);
            TopBarFragment fragmentTopic = (TopBarFragment) getFragmentManager()
                    .findFragmentById(R.id.content_fragment_top);
            moveWidth = radioButton.getWidth();
            paddingLeft = (radioButton.getWidth() - img.getWidth()) / 2;

            switch (checkedId) {

                case R.id.radio_news:
                    fragment.changeContent(0);
                    fragmentTopic.changeContent(0);
                    MoveBg.moveFrontBg(img, startLeft + paddingLeft, 0, 0, 0);
                    startLeft = paddingLeft;
                    break;
                case R.id.radio_topic:
                    fragment.changeContent(1);
                    fragmentTopic.changeContent(1);
                    MoveBg.moveFrontBg(img, startLeft, moveWidth, 0, 0);
                    startLeft = moveWidth;
                    break;
                case R.id.radio_pic:
                    fragment.changeContent(2);
                    fragmentTopic.changeContent(2);
                    MoveBg.moveFrontBg(img, startLeft, moveWidth * 2, 0, 0);
                    startLeft = moveWidth * 2;
                    break;
                case R.id.radio_follow:
                    fragment.changeContent(3);
                    fragmentTopic.changeContent(3);
                    MoveBg.moveFrontBg(img, startLeft, moveWidth * 3, 0, 0);
                    startLeft = moveWidth * 3;
                    break;
                case R.id.radio_vote:
                    fragment.changeContent(4);
                    fragmentTopic.changeContent(4);
                    MoveBg.moveFrontBg(img, startLeft, moveWidth * 4, 0, 0);
                    startLeft = moveWidth * 4;
                    break;

                default:
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (TabHost) findViewById(R.id.tabhost);
        bottom_layout = (FrameLayout) findViewById(R.id.content_bg);

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(checkedChangeListener);

        img = new ImageView(this);
        img.setImageResource(R.drawable.tab_front_bg);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottom_layout.addView(img, layoutParams);

        radioButton = (RadioButton) findViewById(R.id.radio_follow);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        switch (level) {
            case TRIM_MEMORY_UI_HIDDEN:
                break;
            case TRIM_MEMORY_BACKGROUND:
                break;
            case TRIM_MEMORY_COMPLETE:
                break;
            case TRIM_MEMORY_MODERATE:
                break;
            case TRIM_MEMORY_RUNNING_CRITICAL:
                break;
            case TRIM_MEMORY_RUNNING_LOW:
                break;
            case TRIM_MEMORY_RUNNING_MODERATE:
                break;
            default:
                break;
        }
    }
}
