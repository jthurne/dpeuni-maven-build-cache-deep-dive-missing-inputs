# DPE University Training

[<img width="10%" height="10%" src="https://user-images.githubusercontent.com/120980/174325546-8558160b-7f16-42cb-af0f-511849f22ebc.png">](https://dpeuniversity.gradle.com/)
Checkout all the **free** Maven, Gradle, and DPE courses at the [DPE University][dpe-university]!

## Maven Build Cache Deep Dive - Lab 02: Missing Inputs With Build Caching

This is a hands-on exercise to go along with the [Maven Build Cache Deep Dive][course-url] training module. In this exercise you will go over the following:

- What happens when not all the inputs used by a goal are defined.
- How to define additional inputs to the build cache. 

## Prerequisites

- Finished going through the _Inputs and Outputs_ section in Maven Build Cache Deep Dive.
- Java 11+

Steps
-----

1. View the `pom.xml`, pay attention to the `maven-surefire-plugin` configuration and how the `INTEGRATION_TEST_SAMPLES` environment variable is used in `ApplicationStartupTest.java`

2. If you have not completed the previous labs, authenticate Maven with the Develocity server.

> [!NOTE]
> As part of taking this **free** course, you have access to a training instance of Develocity located at:
> ```
>  https://dpeuniversity-develocity.gradle.com/
>  ```
> [Sign in][develocity-url] to this Develocity server using the same account you use for the DPE University.
>
> This server is configured so users can only access the Build Scan® and Build Cache entries they publish.

 Run the following command and follow the instructions in your terminal:

 ```shell
 ./mvnw com.gradle:gradle-enterprise-maven-extension:provision-access-key
 ```
> [!NOTE]
> For more ways to authenticate, see the [authentication guide](https://docs.gradle.com/enterprise/maven-extension/#authenticating_with_gradle_enterprise) to see how to provide credentials.

3. Enable the build cache debug logging to view additional details:

   ```shell
   export MAVEN_OPTS="-Dorg.slf4j.simpleLogger.log.gradle.goal.cache=debug"
   ```

4. Execute the following command **multiple times**:

   ```shell
    ./mvnw clean verify
    ```  

5. Open the Build Scan and look at the **Performance** -> **Goal execution** tab. Can you identify the goals that came `FROM-CACHE`?

6. Change the first line in one of the files under `src/integration-test-samples` so that the assertions in the test case isn't met anymore. Execute the build again. (Does the test fail?)

    ```shell
    ./mvnw clean verify
    ```

7. Add an input for the `maven-surefire-plugin` so that the files under `src/integration-test-samples` are considered. Execute the build again, does the test fail?

    ```shell
    ./mvnw clean verify
    ```

   See the [declaring additional inputs](https://docs.gradle.com/enterprise/maven-extension/#declaring_additional_inputs) guide to see how to add the `src/integration-test-samples` as an input to the test task.

8. Run the build again and see if the tests fail now: 

    ```shell
    ./mvnw clean verify
    ```

9. Fix (or revert) the input files so that the test passes, run the build again:

    ```shell
    ./mvnw clean verify
    ```

## Solution Reference

To see the solution to the lab, check out the [`solution`](https://github.com/gradle/missing-inputs-maven-build-cache-lab/commit/solution) branch of this project.

## More Free Labs & Courses

Be sure to check out our other **free** [courses][dpe-university] and [labs](https://github.com/gradle?q=dpe-university)!

**Related courses:**
- [Maven - Build Cache Deep Dive][course-url]
- [Maven - Maintaining an Optimized Build Cache](https://dpeuniversity.gradle.com/c/42cf9d626302011526c4a0536b26af929b5bef58)
- [Develocity - How to Use Build Scans](https://dpeuniversity.gradle.com/c/0b0b3e4a8d21709ff39074e9962eee6ca4276dc1)

**Related labs:**
- [Lab 01 - Using the local build cache](https://github.com/gradle/getting-started-maven-build-cache-lab)
- [Lab 02 - Missing Inputs With Build Caching](https://github.com/gradle/missing-inputs-maven-build-cache-lab)
- [Lab 03 - Add Build Cache Support to any Maven Plugin](https://github.com/gradle/caching-any-plugin-maven-build-cache-lab)
- [Lab 04 - Handling Cache Misses with Normalization](https://github.com/gradle/cache-misses-maven-build-cache-lab)
- [Lab 05 - Outputs Overwrite Inputs](https://github.com/gradle/outputs-overwrite-inputs-maven-build-cache-lab)
- [Lab 06 - Maintaining an Optimized Build Cache](https://github.com/gradle/maintaining-optimized-cache-maven-build-cache-lab)

[course-url]: https://dpeuniversity.gradle.com/c/47262fea1e74b719afb590d8cb3f8280bf2af732
[dpe-university]: https://dpeuniversity.gradle.com/
[develocity-url]: https://dpeuniversity-develocity.gradle.com/