---
summary: "Full install: nastech-agent plugin + bridge APK + Python dev setup."
read_when:
  - "Installing from scratch"
  - "Debugging a failed install"
  - "Setting up local Python development"
---

# Install

## Plugin (nastech-agent v0.3.0+)

One-liner (`install.sh`):

```bash
curl -sSL https://raw.githubusercontent.com/nastech-ai/nastech-android/main/install.sh | bash
```

What it does:
1. Shallow-clones the repo to a temp dir.
2. Copies `nastech-android-plugin/` → `~/.nastech/plugins/nastech-android`.
3. Installs `aiohttp` if missing (`pip`/`pip3`).
4. Cleans up the temp dir.

Then restart nastech-gateway and run `/plugins` to verify — should show `✓ nastech-android v0.3.0 (38 tools)`.

Manual alternative:
```bash
mkdir -p ~/.nastech/plugins
cp -r nastech-android-plugin ~/.nastech/plugins/nastech-android
```

## Bridge APK

**Option A — prebuilt:** download `nastech-android-<version>.apk` from the [Latest Build release](https://github.com/nastech-ai/nastech-android/releases/tag/latest-build); install on-device or `adb install nastech-android-*.apk`.

**Option B — build from source:**
```bash
cd nastech-android-bridge
./gradlew assembleDebug
adb install app/build/outputs/apk/debug/nastech-android-*.apk
```

It is an unsigned **debug** build (not on Play Store / F-Droid yet).

## Android Automotive (AAOS) head units

Sideload the same APK via `adb install` (USB to the head unit, or `adb connect <ip>:5555`). Grant Accessibility + overlay; skip phone-only perms. For network: `adb forward tcp:8766 tcp:8766` then enter `http://localhost:8766`, or use the relay's `http://<ip>:8766` on the same WiFi. SMS/calls/contacts return errors gracefully.

## Python dev setup

```bash
pip install -e ".[dev]"
python -m pytest tests/
```

Requires Python >=3.11. See [configuration.md](configuration.md) for env vars.
