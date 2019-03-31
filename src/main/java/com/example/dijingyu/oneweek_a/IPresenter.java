package com.example.dijingyu.oneweek_a;

/**
 * 作者：邸某某
 * 时间：2019/3/31
 */

public class IPresenter {

    private IView mIView;
    private IModel mIModel;

    public IPresenter(IView ivew){
        mIView = ivew;
        mIModel = new IModel();
    }

    public void start(){
        mIModel.start(new BackCall() {
            @Override
            public void success(Bean bean) {
                mIView.success(bean);
            }

            @Override
            public void fail(String tips) {
                mIView.fail(tips);
            }
        });
    }

}
