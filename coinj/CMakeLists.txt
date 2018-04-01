# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
             native-crypto

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-crypto.cpp

             # x13
             src/main/cpp/x13/aes_helper.c
             src/main/cpp/x13/blake.c
             src/main/cpp/x13/bmw.c
             src/main/cpp/x13/cubehash.c
             src/main/cpp/x13/echo.c
             src/main/cpp/x13/fugue.c
             src/main/cpp/x13/groestl.c
             src/main/cpp/x13/hamsi_helper.c
             src/main/cpp/x13/hamsi.c
             src/main/cpp/x13/jh.c
             src/main/cpp/x13/keccak.c
             src/main/cpp/x13/luffa.c
             src/main/cpp/x13/shavite.c
             src/main/cpp/x13/simd.c
             src/main/cpp/x13/skein.c
           )

target_include_directories( native-crypto
                            PRIVATE
                            src/main/cpp/x13 )

#target_include_directories( native-crypto
#                            PRIVATE
#                            src/main/cpp/scrypt )

#target_include_directories( native-crypto
#                            PRIVATE
#                            src/../../secp256k1/include
#                            src/../../secp256k1/src
#                            src/../../secp256k1 )



# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       native-crypto

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )