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

package info.pelleritoudacity.android.javajoker;


import java.util.Random;

import info.pelleritoudacity.android.javajoker.utility.Constants;

public class Joker {

    private final Random mRandom;

    public Joker() {
        mRandom = new Random();
    }

    public String getJoke() {
        switch (mRandom.nextInt(Constants.MAX_RANDOM)) {
            case 0:
                return "Mac Gyver can build an airplane out of gum and paper clips. Chuck Norris can kill him and take it.";
            case 1:
                return "Chuck Norris is not hung like a horse. Horses are hung like Chuck Norris.";
            case 2:
                return "When Chuck Norris sends in his taxes, he sends blank forms and includes only a picture of himself, crouched and ready to attack. Chuck Norris has not had to pay taxes, ever.";
            case 3:
                return "Chuck Norris once ate a whole cake before his friends could tell him there was a stripper in it.";
            default:
                return "Chuck Norris drives an ice cream truck covered in human skulls.";

        }

    }
}
