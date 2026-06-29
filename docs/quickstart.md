---
summary: "Get a phone under agent control in about 5 minutes."
read_when:
  - "First-time setup"
  - "Demoing the system end-to-end"
---

# Quickstart

## 1. Install the bridge app on your phone

Easiest: download the prebuilt APK from the [Latest Build release](https://github.com/nastech-ai/nastech-android/releases/tag/latest-build) and install it (enable "Install unknown apps" when prompted, or `adb install nastech-android-*.apk`).

It is an unsigned debug build, so Play Protect may warn on install.

## 2. Grant permissions

In the NasTech app:
- Enable Accessibility Service → toggle NasTech ON.
- Enable Status Overlay → grant.
- Grant Screen Recording (for `android_screen_record`).
- Optional runtime perms (Settings > Apps > NasTech > Permissions): Location, Contacts, SMS, Phone.
- Notification access (Settings > Special app access) for `android_notifications` / `android_events`.

## 3. Connect to your NasTech server

Tell nastech: `Connect to my phone, code is <CODE>` (the 6-char code shown in the app). NasTech replies with the server address — enter it in the app and tap **Connect**.

## 4. Try it

"open Instagram", "take a screenshot", "what apps do I have?"

See [install.md](install.md) for the full plugin install and [troubleshooting.md](troubleshooting.md) if connection fails.
