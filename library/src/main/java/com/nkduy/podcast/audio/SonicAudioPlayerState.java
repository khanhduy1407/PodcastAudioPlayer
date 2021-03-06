/*
 * Copyright © 2021 NKDuy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nkduy.podcast.audio;

import android.util.Log;

class SonicAudioPlayerState {

    private static final String TAG = "SonicAudioPlayerState";

    final static int IDLE = 0;
    final static int INITIALIZED = 1;
    final static int PREPARING = 2;
    final static int PREPARED = 3;
    final static int STARTED = 4;
    final static int PAUSED = 5;
    final static int STOPPED = 6;
    final static int PLAYBACK_COMPLETED = 7;
    final static int END = 8;
    final static int ERROR = 9;

    private int currentState;

    SonicAudioPlayerState() {
        currentState = IDLE;
    }

    void changeTo(int state) {
        currentState = state;
        Log.d(TAG, "Changed to " + toString());
    }

    @Override
    public String toString() {
        switch (currentState) {
            case IDLE:
                return "IDLE";
            case INITIALIZED:
                return "INITIALIZED";
            case PREPARING:
                return "PREPARING";
            case PREPARED:
                return "PREPARED";
            case STARTED:
                return "STARTED";
            case PAUSED:
                return "PAUSED";
            case STOPPED:
                return "STOPPED";
            case PLAYBACK_COMPLETED:
                return "PLAYBACK_COMPLETED";
            case END:
                return "END";
            case ERROR:
                return "ERROR";
            default:
                return "UNKNOWN_STATE";
        }
    }
    
    boolean is(int state) {
        return currentState == state;
    }

    boolean seekingAllowed() {
        return is(STARTED) || is(PREPARED) || is(PAUSED) || is(PLAYBACK_COMPLETED);
    }

    boolean stoppingAllowed() {
        return is(PREPARED) || is(STARTED) || is(STOPPED) || is(PAUSED) || is(PLAYBACK_COMPLETED);
    }

    boolean settingDataSourceAllowed() {
        return is(IDLE);
    }

}
