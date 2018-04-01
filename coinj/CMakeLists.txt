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
             src/main/cpp/aes_helper.c
             src/main/cpp/blake.c
             src/main/cpp/bmw.c
             src/main/cpp/cubehash.c
             src/main/cpp/echo.c
             src/main/cpp/fugue.c
             src/main/cpp/groestl.c
             src/main/cpp/hamsi.c
             src/main/cpp/hamsi_helper.c
             src/main/cpp/hashblock.h
             src/main/cpp/jh.c
             src/main/cpp/keccak.c
             src/main/cpp/luffa.c
             src/main/cpp/shavite.c
             src/main/cpp/simd.c
             src/main/cpp/skein.c
             src/main/cpp/sph_blake.h
             src/main/cpp/sph_bmw.h
             src/main/cpp/sph_cubehash.h
             src/main/cpp/sph_echo.h
             src/main/cpp/sph_fugue.h
             src/main/cpp/sph_groestl.h
             src/main/cpp/sph_hamsi.h
             src/main/cpp/sph_jh.h
             src/main/cpp/sph_keccak.h
             src/main/cpp/sph_luffa.h
             src/main/cpp/sph_shavite.h
             src/main/cpp/sph_simd.h
             src/main/cpp/sph_skein.h
             src/main/cpp/sph_types.h
             src/main/cpp/uint256.h )

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