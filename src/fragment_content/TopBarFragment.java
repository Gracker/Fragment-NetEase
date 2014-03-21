package fragment_content;

import com.gracker.tabfragment.R;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TopBarFragment extends Fragment {
	TextView mTextView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.v("Contentfragment", "Contentfragment_onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v("Contentfragment", "Contentfragment_onCreateView");
		//super.onCreateView(inflater, container, savedInstanceState);
		// Inflate the layout for this fragment
//		TextView testText = (TextView)findViewById(R.id.item_detail);
		return inflater.inflate(R.layout.fragment_topbar, container, false);
	}
	
	public void changeContent(int index) {
		mTextView = (TextView) getActivity().findViewById(
				R.id.fragment_topbar_topic);
		switch (index) {
		case 0:

			mTextView.setText("1");
			break;
		case 1:

			mTextView.setText("2");
			break;
		case 2:

			mTextView.setText("3");
			break;
		case 3:

			mTextView.setText("4");
			break;
		case 4:

			mTextView.setText("5");
			break;
		default:
			break;
		}
	}
}
