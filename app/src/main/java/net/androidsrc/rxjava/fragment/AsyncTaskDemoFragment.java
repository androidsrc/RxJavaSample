package net.androidsrc.rxjava.fragment;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import net.androidsrc.rxjava.R;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by aman.yadav on 01/01/17.
 */
public class AsyncTaskDemoFragment extends BaseFragment {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.textView)
    TextView textView;

    @Override
    public int setLayout() {
        return R.layout.fragment_async_task;
    }

    @OnClick(R.id.button)
    void buttonClicked() {
        startAsyncTask("Hello");
    }

    //-------------------Main logic here-------------------//
    private void startAsyncTask(String input) {
        Observable.just(input)
                .map(this::doInBackground)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(this::onPreExecute)
                .subscribe(this::onPostExecute);
    }

    //------------- full mapping to async task functions -----------------//
    //pre execute work here
    private void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
    }

    //do background things here
    private int doInBackground(String data) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data.length();
    }

    //post execution work here
    private void onPostExecute(int result) {
        progressBar.setVisibility(View.GONE);
        textView.setText("Length of input is " + result);
    }
}
