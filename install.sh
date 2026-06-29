#!/usr/bin/env bash
# One-liner install for nastech-android plugin into nastech-agent v0.3.0+
#
# Usage:
#   curl -sSL https://raw.githubusercontent.com/nastech-ai/nastech-android/main/install.sh | bash
#
set -euo pipefail

PLUGIN_DIR="$HOME/.nastech/plugins/nastech-android"
REPO="https://github.com/nastech-ai/nastech-android.git"
TMP_DIR="$(mktemp -d)"

echo "Installing nastech-android plugin..."

# Clone just the plugin directory (shallow, single-branch)
git clone --depth 1 --single-branch "$REPO" "$TMP_DIR" 2>/dev/null

# Copy plugin into place
mkdir -p "$HOME/.nastech/plugins"
rm -rf "$PLUGIN_DIR"
cp -r "$TMP_DIR/nastech-android-plugin" "$PLUGIN_DIR"

# Install Python dependency (aiohttp) if missing
if ! python3 -c "import aiohttp" 2>/dev/null; then
    echo "Installing aiohttp..."
    pip install aiohttp 2>/dev/null || pip3 install aiohttp 2>/dev/null || echo "Warning: could not install aiohttp — install it manually"
fi

# Cleanup
rm -rf "$TMP_DIR"

echo "✓ nastech-android plugin installed to $PLUGIN_DIR"
echo "  Restart nastech-gateway, then run /plugins to verify."
