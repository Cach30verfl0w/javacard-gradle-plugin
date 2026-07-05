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

package net.cacheoverflow.example;

import javacard.framework.APDU;
import javacard.framework.Applet;
import javacard.framework.ISO7816;
import javacard.framework.ISOException;

public class Test1Applet extends Applet {

    // APDU Konstanten (entsprechen dem Host-Programm)
    private static final byte CLA = (byte) 0x80;
    private static final byte INS_ECHO = (byte) 0x10;
    private static final byte INS_STATUS = (byte) 0x20;

    // Status-Antwort Daten
    private static final byte[] STATUS_DATA = {(byte) 0x4F, (byte) 0x4B}; // "OK"

    // Konstruktor: Wird bei der Installation aufgerufen
    protected Test1Applet(byte[] bArray, short bOffset, byte bLength) {
        register(); // Registrierung bei der Java Card Runtime
    }

    // Instanzierungsmethode
    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new Test1Applet(bArray, bOffset, bLength);
    }

    @Override
    public void process(APDU apdu) {
        // Selektions-APDU automatisch durch Runtime behandeln
        if (selectingApplet()) {
            return;
        }

        byte[] buffer = apdu.getBuffer();

        if (buffer[ISO7816.OFFSET_CLA] != CLA) {
            ISOException.throwIt(ISO7816.SW_CLA_NOT_SUPPORTED);
        }

        // Verzweigung basierend auf INS
        switch (buffer[ISO7816.OFFSET_INS]) {
            case INS_ECHO:
                apdu.setOutgoing();
                apdu.setOutgoingLength((short) STATUS_DATA.length);
                apdu.sendBytesLong(STATUS_DATA, (short) 0, (short) STATUS_DATA.length);
                break;

            case INS_STATUS:
                // Status senden
                apdu.setOutgoing();
                apdu.setOutgoingLength((short) STATUS_DATA.length);
                apdu.sendBytesLong(STATUS_DATA, (short) 0, (short) STATUS_DATA.length);
                break;

            default:
                ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
        }
    }
}