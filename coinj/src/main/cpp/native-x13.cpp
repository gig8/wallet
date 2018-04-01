/**
 * Created by Hash Engineering on 4/24/14 for the X11 algorithm
 * Modified by gig8 on 3/31/18 for the X13 algorithm
 */
#include "hashblock.h"
#include <jni.h>

extern "C" JNIEXPORT jbyteArray

JNICALL
Java_com_gig8_coinj_X13_getHash(
        JNIEnv *env,
        jobject, /* this */
        jbyteArray header) {
    jint Plen = (env)->GetArrayLength(header);
    jbyte *P = (env)->GetByteArrayElements(header, NULL);
    jbyteArray DK = NULL;
    if (P) {
        uint256 result = Hash9(P, P + Plen);
        DK = (env)->NewByteArray(32);
        if (DK)
        {
            (env)->SetByteArrayRegion(DK, 0, 32, (jbyte *) result.begin());
        }
        (env)->ReleaseByteArrayElements(header, P, JNI_ABORT);
    }
    return DK;
}