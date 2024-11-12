#!/usr/bin/env bash
echo "Cleaning Gradle cache to prevent workspace modification issues"
rm -rf $HOME/.gradle/caches/
rm -rf $HOME/.gradle/workers/
rm -rf $HOME/.gradle/daemon/
rm -rf .gradle