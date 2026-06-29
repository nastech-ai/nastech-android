# NasTech Android — Agent Guide

NasTech Android is a companion app for NasTech Agent that runs on Android devices,
enabling full remote device control via a WebSocket relay.

## Architecture

```
Phone (NasTech APK)  ──WebSocket──>  Relay (port 8766)  ──HTTP──>  NasTech Agent
```

The phone connects **out** to the relay (NAT-friendly, no port forwarding).
The relay bridges HTTP tool calls to the phone over WebSocket.

## Project Structure

| Component | Path | Language | Purpose |
|-----------|------|----------|---------|
| Android bridge app | `nastech-android-bridge/` | Kotlin | Runs on the phone; executes commands via AccessibilityService |
| Python toolset | `tools/`, `tests/`, `nastech-android-plugin/` | Python | Runs on the server; `nastech_*` tools + WebSocket relay |

## Build

```bash
cd nastech-android-bridge
./gradlew assembleDebug
```

APK output: `nastech-android-bridge/app/build/outputs/apk/debug/nastech-android-<version>.apk`

## CI/CD

GitHub Actions (`.github/workflows/build.yml`) auto-builds on push to `main`.
APKs are published to the `latest-build` release.

## Plugin Integration

Drop `nastech-android-plugin/` into `~/.nastech/plugins/nastech-android/`
and restart NasTech Agent. All `nastech_*` tools auto-register.

## Copyright

Copyright © 2026 Naswif Cohen Nsamba / NasTech
