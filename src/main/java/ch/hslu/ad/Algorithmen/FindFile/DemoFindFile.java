/*
 * Copyright 2022 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.Algorithmen.FindFile;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Codevorlage für eine Dateisuche.
 */
public final class DemoFindFile {

    private static final Logger LOG = LogManager.getLogger(DemoFindFile.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFindFile() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final String search = "Text.docx";
        final File rootDir = new File(System.getProperty("user.home"));

        LOG.info("Start searching '{}' recurive in '{}'", search, rootDir);
        long startTime = System.currentTimeMillis();
        FindFile.findFile(search, rootDir);
        LOG.info("Found in {} sec.", (float)(System.currentTimeMillis()-startTime/1000));

        LOG.info("Find '{}' concurrent in '{}'", search, rootDir);
        final FindFileTask root = new FindFileTask(search, rootDir);
        startTime = System.currentTimeMillis();
        //LOG.info(root.invoke());
        root.invoke();
        LOG.info(root.getRawResult());
        LOG.info("Found in {} sec.", (float)(System.currentTimeMillis()-startTime/1000));
    }
}
