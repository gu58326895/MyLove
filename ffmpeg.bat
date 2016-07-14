@echo off
ffmpeg -i %1 -r 25 %2
ffmpeg -i %3 -ss -20 -vframes 1 -r 1 -ac 1 -ab 2 -s 212*140 -f image2 %4

exit