package dev.rosewood.rosegarden.command.argument;

import dev.rosewood.rosegarden.RosePlugin;
import dev.rosewood.rosegarden.command.framework.ArgumentParser;
import dev.rosewood.rosegarden.command.framework.RoseCommandArgumentHandler;
import dev.rosewood.rosegarden.command.framework.RoseCommandArgumentInfo;
import java.util.Collections;
import java.util.List;

public class StringArgumentHandler extends RoseCommandArgumentHandler<String> {

    public StringArgumentHandler(RosePlugin rosePlugin) {
        super(rosePlugin, String.class);
    }

    @Override
    protected String handleInternal(RoseCommandArgumentInfo argumentInfo, ArgumentParser argumentParser) {
        String input = argumentParser.next();
        if (input.trim().isEmpty())
            throw new HandledArgumentException("argument-handler-string");
        return input;
    }

    @Override
    protected List<String> suggestInternal(RoseCommandArgumentInfo argumentInfo, ArgumentParser argumentParser) {
        argumentParser.next();
        return Collections.singletonList(argumentInfo.toString());
    }

}
