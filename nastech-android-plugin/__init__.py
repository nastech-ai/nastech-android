"""
nastech-android plugin — registers 14 android_* tools into nastech-agent via the
v0.3.0 plugin system.

Drop this folder into ~/.nastech/plugins/nastech-android and restart nastech.
"""

from .android_tool import _SCHEMAS, _HANDLERS, _check_requirements


def register(ctx):
    """Called by nastech-agent plugin loader. Registers all android_* tools."""
    for tool_name, schema in _SCHEMAS.items():
        ctx.register_tool(
            name=tool_name,
            toolset="android",
            schema=schema,
            handler=_HANDLERS[tool_name],
            check_fn=(lambda: True) if tool_name == "android_setup" else _check_requirements,
        )
