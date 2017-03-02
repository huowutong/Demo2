package demo.android.com.cleartextviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;

/**
 * Created by LuTao on 2017/02/15.
 */
public class ClearEditText extends LinearLayout {
    public ClearEditText(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    @Bind(R.id.et_input)
    EditText input;

    @Bind(R.id.iv_clear_text)
    ImageView ivClearText;

    @OnTextChanged(R.id.et_input)
    void onTextChanged(CharSequence text) {
        if (text.length() > 0 && input.hasFocus()) {
            ivClearText.setVisibility(View.VISIBLE);
        } else {
            ivClearText.setVisibility(View.INVISIBLE);
        }
    }

    @OnFocusChange(R.id.et_input)
    void onOnFocusChange(boolean focused) {
        if (focused) {
            ivClearText.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.iv_clear_text)
    public void clear() {
        ivClearText.setVisibility(INVISIBLE);
        input.setText("");
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        LayoutInflater.from(context).inflate(R.layout.layout_clear_edittext, this);
        ButterKnife.bind(this);

        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.ClearEditText, defStyle, 0);

        String hint = a.getString(
                R.styleable.ClearEditText_hintString);
        input.setHint(hint);
        a.recycle();
        ivClearText.setVisibility(INVISIBLE);

    }

    public void setEditTextText(String text) {
        input.setText(text);
    }

    public String getText() {
        return input.getText().toString();
    }

    public void setText(String text) {
        input.setText(text);
        input.setSelection(text.length());
    }
}
