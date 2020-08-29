package pers.jay.common.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import pers.jay.common.R;

public class TitleBar extends Toolbar {

    private final Context mContext;
    private View mView;
    private ViewHolder viewHolder;
    private OnToolBarClickListener mListener;

    private int mBackground;
    private int mLeftSrc;
    private int mRightSrc;
    public String mTitle;
    public int mTitleColor;
    private float mTitleSize;

    public void setToolBarClickListener(OnToolBarClickListener mListener) {
        this.mListener = mListener;
    }

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initArgs(context, attrs);
        initView();
    }

    private void initArgs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        mBackground = array.getResourceId(R.styleable.TitleBar_tb_background, getColor(R.color.white));
        mLeftSrc = array.getResourceId(R.styleable.TitleBar_tb_left_image, 0);
        mRightSrc = array.getResourceId(R.styleable.TitleBar_tb_right_image, 0);
        mTitle = array.getString(R.styleable.TitleBar_tb_title);
        mTitleColor = array.getColor(R.styleable.TitleBar_tb_title_color, getColor(R.color.white));
        mTitleSize = array.getDimension(R.styleable.TitleBar_tb_title_size, sp2px(15));
        array.recycle();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if (mView == null) {
            mView = inflater.inflate(R.layout.title_bar, null);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, Gravity.CENTER_HORIZONTAL);
            this.addView(mView, params);
        }
        viewHolder = new ViewHolder(this);
        mView.setBackgroundColor(getColor(mBackground));
        if (mLeftSrc != 0) {
            viewHolder.ivLeft.setImageResource(mLeftSrc);
        }
        if (mRightSrc != 0) {
            viewHolder.ivRight.setImageResource(mRightSrc);
        }
        viewHolder.tvTitle.setText(mTitle);
        viewHolder.tvTitle.setTextColor(mTitleColor);
        viewHolder.ivLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener == null) {
                    return;
                }
                mListener.onLeftClick(viewHolder.ivLeft);
            }
        });
        viewHolder.ivRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener == null) {
                    return;
                }
                mListener.onRightClick(viewHolder.ivRight);
            }
        });
    }

    @Override
    public void setContentInsetStartWithNavigation(int insetStartWithNavigation) {
        super.setContentInsetStartWithNavigation(insetStartWithNavigation);
    }

    public void setTitle(String title) {
        this.mTitle = title == null ? null : title.trim();
        viewHolder.tvTitle.setText(title);
    }

    @Override
    public void setTitle(int resId) {
        viewHolder.tvTitle.setText(resId);
    }

    public void setTitleColor(@ColorRes int resId) {
        this.mTitleColor = resId;
        viewHolder.tvTitle.setTextColor(getColor(resId));
    }

    public void setTitleSize(float titleSize) {
        this.mTitleSize = titleSize;
        viewHolder.tvTitle.setTextSize(titleSize);
    }

    public void setBackground(@ColorRes int backgroundRes) {
        this.mBackground = backgroundRes;
        mView.setBackgroundColor(getColor(backgroundRes));
    }

    public void setLeftSrc(@ColorRes int leftSrc) {
        this.mLeftSrc = leftSrc;
        viewHolder.ivLeft.setImageResource(getColor(leftSrc));
    }

    public void setRightSrc(@ColorRes int rightSrc) {
        this.mRightSrc = rightSrc;
        viewHolder.ivRight.setImageResource(rightSrc);
    }

    private int getColor(@ColorRes int id) {
        return ContextCompat.getColor(mContext, id);
    }

    private static class ViewHolder {

        ImageView ivLeft;
        ImageView ivRight;
        TextView tvTitle;

        private ViewHolder(View view) {
            ivLeft = view.findViewById(R.id.iv_bar_left);
            ivRight = view.findViewById(R.id.iv_bar_right);
            tvTitle = view.findViewById(R.id.tv_bar_title);
        }
    }

    public interface OnToolBarClickListener {
        void onLeftClick(View v);
        void onRightClick(View v);
    }

    private float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }

    private float sp2px(float sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                Resources.getSystem().getDisplayMetrics());
    }
}
