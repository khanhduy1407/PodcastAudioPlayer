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

class DownMixer {

    static void downMix(byte[] modifiedSamples) {
        for (int i = 0; (i + 3) < modifiedSamples.length; i += 4) {
            short left = (short) ((modifiedSamples[i] & 0xff) | (modifiedSamples[i + 1] << 8));
            short right = (short) ((modifiedSamples[i + 2] & 0xff) | (modifiedSamples[i + 3] << 8));
            short value = (short) (0.5 * left + 0.5 * right);

            modifiedSamples[i] = (byte) (value & 0xff);
            modifiedSamples[i + 1] = (byte) (value >> 8);
            modifiedSamples[i + 2] = (byte) (value & 0xff);
            modifiedSamples[i + 3] = (byte) (value >> 8);
        }
    }

}
