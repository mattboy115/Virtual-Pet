## A New Home for Every Paw
In the heart of a bustling city, the local pet shelter, "Paws & Claws Haven," had been working tirelessly to find loving homes for the animals in their care. Despite their best efforts, the shelter struggled with an outdated system for managing pet adoptions and engaging with the community.

Maggie, the shelter manager, often found herself overwhelmed by the constant phone calls and emails from potential adopters. The shelter's limited online presence made it difficult for people to see which pets were available or learn about the shelter's needs and events. Many families interested in adopting had to visit the shelter in person, which was inconvenient for those with busy schedules or limited mobility.

One day, a local volunteer named Alex suggested creating a dedicated website for the shelter. Alex believed that an online platform could streamline the adoption process, making it easier for people to find and adopt pets. He envisioned a site where visitors could browse photos and descriptions of available pets, submit adoption applications, and learn about upcoming events and donation opportunities—all from the comfort of their own homes.

Maggie was intrigued by the idea but worried about the costs and effort involved. Alex, however, assured her that there were affordable options for building and maintaining the website. He offered to help with the project, drawing on his tech skills and connections in the local tech community.

With renewed hope, Maggie agreed to move forward with the plan. The website project quickly gained traction, and within a few months, "Paws & Claws Haven" launched their new online platform. The site featured an easy-to-use interface, allowing visitors to search for pets by breed, age, and size, view detailed profiles, and apply for adoption online. The shelter also set up pages for events, volunteer opportunities, and donation drives.

The impact was immediate. Adoption inquiries increased as more people discovered the shelter through the website. Potential adopters could browse pets at their convenience, reducing the number of visits needed to the shelter and increasing the likelihood of finding the perfect match. The shelter staff could now manage adoptions and pet information more efficiently, freeing up time to focus on caring for the animals.

The community rallied around the shelter, inspired by the new website and eager to support its mission. Volunteers signed up for shifts, and donations flowed in more regularly. The website became a vital tool in the shelter's efforts to find homes for every paw and ensure that the animals in their care had the best possible chance of finding a loving family.

Thanks to the website, "Paws & Claws Haven" not only improved its operations but also strengthened its connection with the community, making a lasting difference in the lives of countless animals and their future families.

 
## PetModel fields
long id;
String name;
PetType type (enum);
int age;
int health (precentage);
int happiness (precentage);;
int hungery (precentage);;
DeathBy died (enum);

### Phase 1
1. Build classes
   - PetModel class
   - DogModel class
   - CatModel class
2. Build Enums
   - PetType
   - DeathBy
3. Validate data models in all class methods
   - Name is required
   - Name has a max length of 50
   - Age is Required and must be between 0 an 20
   - Pet Type can only be "Cat" or "Dog"
   - Health can not be less then 0%. (0% the animal is dead)
   - Happiness can not be less then 0%. (0% the animal is dead)
   - Hungery can not be less then 0%. (100% animal is dead)
4. The passage of time must be incorporated into the pet models.
    - all properties must be effectived
      - Health
      - Happiness
      - Hunger
5. The application must be able to give the status of any pet.
6. add UnitTest to test each method and class
7. add UnitTest to make sure validation is correct

**Nothing should break or throw an exception**

## User Stories
# PetModel User Stories and Acceptance Criteria

## User Story 1: Create a New Pet

As a user, I want to create a new virtual pet so that I can start interacting with it.

### Acceptance Criteria
- The pet must have a unique identifier.
- The pet must have a name, type, and age.
- The pet's health, happiness, and hunger levels must initialize to 0.
- The pet's death status must initialize to 'None'.

## User Story 2: Feed the Pet

As a user, I want to feed my pet so that it stays healthy and happy.

### Acceptance Criteria
- Feeding the pet should decrease its hunger level by 10.
- Feeding the pet should increase its health by 5.
- Feeding the pet should increase its happiness by 15.
- The pet should not be able to be fed if it is dead.

## User Story 3: Play with the Pet

As a user, I want to play with my pet so that it stays happy.

### Acceptance Criteria
- Playing with the pet should increase its hunger level by 15.
- Playing with the pet should increase its health by 10.
- Playing with the pet should increase its happiness by 20.
- The pet should not be able to be played with if it is dead.

## User Story 4: Heal the Pet

As a user, I want to heal my pet so that it stays healthy.

### Acceptance Criteria
- Healing the pet should increase its hunger level by 15.
- Healing the pet should increase its health by 10.
- Healing the pet should increase its happiness by 20.
- The pet should not be able to be healed if it is dead.

## User Story 5: Check Pet's Health

As a user, I want to check the health of my pet so that I can monitor its wellbeing.

### Acceptance Criteria
- The system should return a message stating the pet's health status.
- If the pet is dead, the system should return the cause of death.
- If the pet's health is below 20%, the system should indicate that the pet is not healthy.
- If the pet is healthy, the system should return the pet's details.

## User Story 6: Check Pet's Happiness

As a user, I want to check the happiness of my pet so that I can monitor its emotional state.

### Acceptance Criteria
- The system should return a message stating the pet's happiness status.
- If the pet is dead, the system should return the cause of death.
- If the pet's happiness is below 20%, the system should indicate that the pet is not happy.
- If the pet is happy, the system should return the pet's details.

## User Story 7: Simulate Passage of Time

As a user, I want to simulate the passage of time so that I can see how my pet's state changes over time.

### Acceptance Criteria
- The pet's hunger level should increase over time.
- The pet's happiness level should decrease over time.
- The pet's health level should decrease over time.
- If the pet's hunger reaches 100, it should die of starvation.
- If the pet's happiness reaches 0, it should die of loneliness.
- If the pet's health reaches 0, it should die of disease.


|points|Description|
|-----|--------|
|5pts|Code Commented|
|5pts|Clean Code Standards followed|
|5pts|can build Application|
|65pts|All 13 PetModelTest commpleted (5pts for each)|
|60pts|All 12 CatModelTest commpleted (5pts for each)|
|40pts|All 8 DogModelTest commpleted (5pts for each)|
