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

package info.pelleritoudacity.android.androidjoker.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import info.pelleritoudacity.android.androidjoker.R;
import info.pelleritoudacity.android.androidjoker.utility.Costants;

public class JokerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);

        TextView textview = findViewById(R.id.joke_text);

        Intent intent = getIntent();
        String strJoke = intent.getStringExtra(Costants.EXTRA_JOKE_KEY);

        if (TextUtils.isEmpty(strJoke)) {
            textview.setText(R.string.joke_no_text);
        } else {
            textview.setText(strJoke);
        }

    }
}
