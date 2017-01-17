package net.androidsrc.rxjava.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;

import net.androidsrc.rxjava.R;

import butterknife.BindView;

/**
 * Created by aman.yadav on 01/01/17.
 */
public class RxBindingTextWatcherDemo extends BaseFragment {

    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.etTextListener)
    EditText editText;

    @Override
    public int setLayout() {
        return R.layout.fragment_et_listener;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRxListener();
    }

    //-------------------Main logic here-------------------//
    private void setupRxListener() {
        RxTextView.textChanges(editText).subscribe(text -> {
            textView.setText(text);
        });
    }
}
