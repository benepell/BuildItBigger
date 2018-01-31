/*
 * ______       _ _     _   _____ _    ______ _
 * | ___ \     (_) |   | | |_   _| |   | ___ (_)
 * | |_/ /_   _ _| | __| |   | | | |_  | |_/ /_  __ _  __ _  ___ _ __
 * | ___ \ | | | | |/ _` |   | | | __| | ___ \ |/ _` |/ _` |/ _ \ '__|
 * | |_/ / |_| | | | (_| |  _| |_| |_  | |_/ / | (_| | (_| |  __/ |
 * \____/ \__,_|_|_|\__,_|  \___/ \__| \____/|_|\__, |\__, |\___|_|
 *                                               __/ | __/ |
 *                                              |___/ |___/
 * Copyright (C) 2018 Benedetto Pellerito
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.udacity.gradle.builditbigger.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

    private final Context mContext;
    public Util(Context context) {
        mContext = context;
    }

    public String getDeviceId() {
        @SuppressLint("HardwareIds") String android_id = Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID);
        return  md5(android_id).toUpperCase();
    }

    private String md5(final String s) {
        String strMd5 = null;

        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                StringBuilder h = new StringBuilder(Integer.toHexString(0xFF & aMessageDigest));
                while (h.length() < 2)
                    h.insert(0, "0");
                hexString.append(h);
            }
            strMd5 = hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            Log.d("Util.java", "benny: " + e.getMessage());
        }
        return strMd5;
    }

}