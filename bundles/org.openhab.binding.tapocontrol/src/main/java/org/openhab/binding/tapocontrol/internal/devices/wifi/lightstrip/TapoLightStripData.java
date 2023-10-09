/**
 * Copyright (c) 2010-2023 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.tapocontrol.internal.devices.wifi.lightstrip;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.binding.tapocontrol.internal.devices.dto.TapoBaseDeviceData;
import org.openhab.binding.tapocontrol.internal.devices.dto.TapoLightEffectData;
import org.openhab.core.library.types.DecimalType;
import org.openhab.core.library.types.HSBType;
import org.openhab.core.library.types.PercentType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Tapo-Device Information class
 *
 * @author Christian Wild - Initial contribution
 */
@NonNullByDefault
public class TapoLightStripData extends TapoBaseDeviceData {
    @SerializedName("device_on")
    @Expose(serialize = true, deserialize = true)
    private boolean deviceOn = false;

    @Expose(serialize = true, deserialize = true)
    private int brightness = 0;

    @SerializedName("color_temp")
    @Expose(serialize = true, deserialize = true)
    private int colorTemp = 0;

    @Expose(serialize = true, deserialize = true)
    private int hue = 0;

    @Expose(serialize = true, deserialize = true)
    private int saturation = 100;

    @SerializedName("on_time")
    @Expose(serialize = false, deserialize = true)
    private long onTime = 0;

    @SerializedName("lighting_effect")
    @Expose(serialize = false, deserialize = true)
    private List<TapoLightEffectData> lightingEffect = List.of();

    /***********************************
     *
     * SET VALUES
     *
     ************************************/
    public void switchOn() {
        deviceOn = true;
    }

    public void switchOff() {
        deviceOn = false;
    }

    public void switchOnOff(boolean on) {
        deviceOn = on;
    }

    public void setBrightness(int value) {
        brightness = value;
    }

    public void setColorTemp(int value) {
        colorTemp = value;
    }

    public void setHue(int value) {
        hue = value;
    }

    public void setSaturation(int value) {
        saturation = value;
    }

    /***********************************
     *
     * GET VALUES
     *
     ************************************/

    public int getBrightness() {
        return brightness;
    }

    public int getColorTemp() {
        return colorTemp;
    }

    public HSBType getHSB() {
        DecimalType h = new DecimalType(hue);
        PercentType s = new PercentType(saturation);
        PercentType b = new PercentType(brightness);
        return new HSBType(h, s, b);
    }

    public int getHue() {
        return hue;
    }

    public TapoLightEffectData getLightEffect() {
        return lightingEffect.get(0);
    }

    public boolean isOff() {
        return !deviceOn;
    }

    public boolean isOn() {
        return deviceOn;
    }

    public int getSaturation() {
        return saturation;
    }

    public Number getOnTime() {
        return onTime;
    }
}
