package com.example.qrscanner.ui.theme

import com.google.mlkit.vision.barcode.BarcodeScannerOptions.Builder
import com.google.mlkit.vision.barcode.common.Barcode

    val options = Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_QR_CODE,
            Barcode.FORMAT_CODABAR,
            Barcode.FORMAT_CODE_93,
            Barcode.FORMAT_CODE_39,
            Barcode.FORMAT_CODE_128,
            Barcode.FORMAT_EAN_8,
            Barcode.FORMAT_EAN_13,
            Barcode.FORMAT_AZTEC
        )
        .build()
