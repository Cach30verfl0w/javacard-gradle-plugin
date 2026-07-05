/*
 * Copyright 2026 Cedric Hammes <contact@cach30verfl0w.net>
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

package net.cacheoverflow.javacard.plugin.util

import java.io.OutputStream

class CombinedOutputStream(private val out1: OutputStream?, private val out2: OutputStream) : OutputStream() {
    override fun write(data: Int) {
        out1?.write(data)
        out2.write(data)
    }

    override fun write(b: ByteArray?, off: Int, len: Int) {
        out1?.write(b, off, len)
        out2.write(b, off, len)
    }

    override fun flush() {
        out1?.flush()
        out2.flush()
    }

    override fun close() {
        out1?.close()
        out2.close()
    }
}
