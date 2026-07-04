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

/**
 * @author Cedric Hammes
 * @since  04/07/2026
 */
enum class JavaCardVersion(private val version: String) {
    VERSION_304("3.0.4"),
    VERSION_305("3.0.5"),
    VERSION_306("3.0.6"),
    VERSION_310("3.1.0"),
    VERSION_320("3.2.0");

    override fun toString(): String = version

    companion object {
        @JvmStatic
        fun fromString(value: String): JavaCardVersion =
            JavaCardVersion.entries.firstOrNull { it.version == value }
                ?: throw IllegalArgumentException("Unrecognized or unsupported Java Card API version: $value")
    }
}
