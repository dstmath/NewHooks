package com.dexposedart.newhook.TestHook;

import android.view.View;

import com.taobao.android.dexposed.Hook22_23.utils.HookLog;
import com.taobao.android.dexposed.XC_MethodHook;
import com.taobao.android.dexposed.annotations.Hook;


/**
 * 作者：zhangzhongping on 17/4/3 23:29
 * 邮箱：android_dy@163.com
 * extends XC_MethodReplacement 是用来兼容dalvik虚拟机hook 实现方法是直接替换原方法的
 * extends XC_MethodHook 也是用来兼容dalvik虚拟机hook  两个实现方法是 一个是被hook方法执行前执行  一个是被hook方法执行后执行
 */
@Hook(Class = "com.dexposedart.newhook.MainActivity", Name = "Toasts",
        Type = {Boolean[].class, String.class, View[].class}, returnVal = String.class)
public class TestProxy1 extends XC_MethodHook {

    @Override
    public MethodHookParam beforeHookedMethod(MethodHookParam param) throws Throwable {
        HookLog.e("beforeHookedMethod");
        param.args[1] = param.args[1] + "hook---";
        return param;
    }

    @Override
    public MethodHookParam afterHookedMethod(MethodHookParam param) throws Throwable {
        param.setResult(param.getResult() + "hook");
        HookLog.e(param.getResult() + "");
        return param;
    }
}
