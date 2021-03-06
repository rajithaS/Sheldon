package com.malinskiy.sheldon2.provider;

import com.malinskiy.sheldon2.GatewayBuilder;
import com.malinskiy.sheldon2.IGateway;

import android.content.Context;

import javax.annotation.Nonnull;

public class SharedPreferencesGatewayBuilder extends GatewayBuilder {

    @Nonnull protected Context context;
    protected int mode = Context.MODE_PRIVATE;

    public SharedPreferencesGatewayBuilder(@Nonnull Context context) {
        assert context != null;
        this.context = context;
    }

    public SharedPreferencesGatewayBuilder mode(int mode) {
        this.mode = mode;
        return this;
    }

    @Override protected AllSet prepare() {
        return new AllSet() {
            @Override public IGateway build() {
                return new SharedPreferencesGateway(context.getSharedPreferences(namespace, mode));
            }
        };
    }
}
