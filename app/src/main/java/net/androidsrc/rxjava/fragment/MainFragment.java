package net.androidsrc.rxjava.fragment;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import net.androidsrc.rxjava.R;

import butterknife.OnClick;

public class MainFragment extends BaseFragment {

    @Override
    public int setLayout() {
        return R.layout.fragment_main;
    }

    @OnClick(R.id.btn_async_task)
    void demoConcurrencyWithSchedulers() {
        clickedOn(new AsyncTaskDemoFragment());
    }


    private void clickedOn(@NonNull Fragment fragment) {
        final String tag = fragment.getClass().toString();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(tag)
                .replace(android.R.id.content, fragment, tag)
                .commit();
    }


}
