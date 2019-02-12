package com.cdx.example.staticlayout.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

public class Test1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    public class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        public MyView(Context context, AttributeSet attrs){
            super(context, attrs);
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        public void onDraw(Canvas canvas){
            super.onDraw(canvas);
            //1、构造画笔。
            TextPaint tp = new TextPaint();
            tp.setColor(Color.BLUE);
            tp.setStyle(Paint.Style.FILL);
            tp.setTextSize(50);

            //2、构造StaticLayout对象。
            String message = "paint,draw paint指用颜色画,如油画颜料、水彩或者水墨画,而draw 通常指用铅笔、钢笔或者粉笔画,后者一般并不涂上颜料。两动词的相应名词分别为p";

            //下面展示2种办法用来构造StaticLayout()
            //第一种办法：使用构造函数的形式用来生成对象，但是这种办法已经被废弃了。
            //下面是构造函数和对应的参数的介绍
            //StaticLayout(CharSequence source, //需要分行的字符串
            //           int bufstart,//需要分行的字符串从第几的位置开始
            //           int bufend,//需要分行的字符串到哪里结束
            //           TextPaint paint,//画笔对象
            //           int outerwidth,//layout的宽度，字符串超出宽度时自动换行。
            //           Alignment align,//layout的对其方式，有ALIGN_CENTER， ALIGN_NORMAL， ALIGN_OPPOSITE 三种。
            //           float spacingmult,//相对行间距，相对字体大小，1.5f表示行间距为1.5倍的字体高度。
            //           float spacingadd,//在基础行距上添加多少,实际行间距等于这两者的和。
            //           boolean includepad,//参数未知
            //           TextUtils.TruncateAt ellipsize,//从什么位置开始省略
            //           int ellipsizedWidth)//超过多少开始省略
            StaticLayout myStaticLayout = new StaticLayout(message,
                    tp,
                    canvas.getWidth(),
                    Layout.Alignment.ALIGN_NORMAL,
                    1.0f,
                    0.0f,
                    false);

            //第二种办法：利用Builder的形式生成StaticLayout对象。
            StaticLayout myStaticLayout2 = StaticLayout.Builder
                    .obtain(message, 0, message.length(), tp, canvas.getWidth())
                    .setAlignment(Layout.Alignment.ALIGN_NORMAL)
                    .setEllipsize(TextUtils.TruncateAt.END)
                    .build();

            //3、将StaticLayout中的东西绘制在canvas。
            myStaticLayout2.draw(canvas);

            //4、保存。
            canvas.save();
        }
    }
}
