package com.blank.pickpic.ext

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle


fun Context.getMetadata(): Bundle =
    packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA).metaData