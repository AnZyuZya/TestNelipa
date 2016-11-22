package com.nelipa.test.a_container;

import android.content.Context;
import android.content.Intent;

import com.nelipa.test.R;
import com.nelipa.test.f_tab_one.TabOneFragment;
import com.nelipa.test.f_tab_two.TabTwoFragment;
import com.nelipa.test.s_randomizer.RandomizerService;

import goldzweigapps.tabs.Builder.EasyTabsBuilder;
import goldzweigapps.tabs.Colors.EasyTabsColors;
import goldzweigapps.tabs.Items.TabItem;
import goldzweigapps.tabs.View.EasyTabs;

public class Navigator {
    private Context context;

    public Navigator(Context context) {
        this.context = context;
    }

    public void initTabNavigation(EasyTabs tabs) {
        EasyTabsBuilder.with(tabs)
                .addTabs(
                        new TabItem(new TabOneFragment(), context.getString(R.string.tv_tab_one)),
                        new TabItem(new TabTwoFragment(), context.getString(R.string.tv_tab_two))
                )
                .setTabsBackgroundColor(EasyTabsColors.Azure)
                .setTextColors(EasyTabsColors.BlueViolet, EasyTabsColors.Gray)
                .Build();
    }

    public void startService(){
        context.startService(new Intent(context, RandomizerService.class));
    }

    public void stopService(){
        context.stopService(new Intent(context, RandomizerService.class));
    }

    public void startContainerActivity(){
        Intent containerIntent = new Intent(context, ContainerActivity.class);
        containerIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(containerIntent);
    }
}
