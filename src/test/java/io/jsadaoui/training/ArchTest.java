package io.jsadaoui.training;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("io.jsadaoui.training");

        noClasses()
            .that()
            .resideInAnyPackage("io.jsadaoui.training.service..")
            .or()
            .resideInAnyPackage("io.jsadaoui.training.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..io.jsadaoui.training.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
