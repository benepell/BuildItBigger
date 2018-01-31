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

package com.udacity.gradle.builditbigger.model;

public interface OnJokeReceive {
    void onReceive(String string);
}