<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BestMusic</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/splide.min.css">


</head>

<body>
    <header>
        <div id="menu" class="container">
            <nav id="menu_mobile">
                <a id="link" href="#"><span id="burger"></span></a>
                <a href="index.php"><h2>Best Music</h2></a>
                <ul class="list-unstyled">
                    <li><a href="index.php">Accueil</a></li>
                    <li><a href="selections.php">Nos Sélections</a></li>
                    <li><a href="#">Genre Musicaux</a></li>
                    <li><a href="#">Notre Blog</a></li>
                </ul>
            </nav>
            <div id="logo_search">
            <a href="index.php"><h2 id="titre_desktop">Best Music</h2></a>
                <input id="searchbar_desktop" type="text" placeholder="&#xF002;Rechercher un artiste,un titre...">
            </div>
            <div id="logo">
                <svg width="23" height="20" viewBox="0 0 23 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M20.4587 1.44255C17.8791 -0.726502 13.8935 -0.400698 11.4255 2.11201C8.95739 -0.400698 4.97187 -0.730966 2.39221 1.44255C-0.964018 4.26767 -0.47308 8.87356 1.91913 11.3149L9.74735 19.2904C10.1937 19.7456 10.7917 20 11.4255 20C12.0637 20 12.6573 19.7501 13.1036 19.2948L20.9318 11.3193C23.3196 8.87803 23.8194 4.27214 20.4587 1.44255ZM19.4054 9.81081L11.5772 17.7863C11.4701 17.8934 11.3808 17.8934 11.2737 17.7863L3.4455 9.81081C1.81647 8.15055 1.48621 5.00854 3.7713 3.08496C5.50743 1.62554 8.18528 1.84423 9.86339 3.55358L11.4255 5.1469L12.9875 3.55358C14.6746 1.8353 17.3524 1.62554 19.0796 3.0805C21.3603 5.00408 21.0211 8.16393 19.4054 9.81081Z"
                        fill="white" />
                </svg>
                <svg width="27" height="20" viewBox="0 0 27 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M24.1667 0H2.5C1.11927 0 0 1.11927 0 2.5V17.5C0 18.8807 1.11927 20 2.5 20H24.1667C25.5474 20 26.6667 18.8807 26.6667 17.5V2.5C26.6667 1.11927 25.5474 0 24.1667 0ZM24.1667 2.5V4.62526C22.9989 5.57625 21.1371 7.055 17.1569 10.1716C16.2798 10.8616 14.5423 12.5191 13.3333 12.4998C12.1246 12.5193 10.3865 10.8613 9.50974 10.1716C5.53021 7.05547 3.66797 5.57641 2.5 4.62526V2.5H24.1667ZM2.5 17.5V7.83323C3.69344 8.7838 5.38589 10.1177 7.96552 12.1377C9.10391 13.0338 11.0975 15.012 13.3333 14.9999C15.5582 15.012 17.5265 13.0625 18.7007 12.1381C21.2803 10.1182 22.9732 8.78391 24.1667 7.83328V17.5H2.5Z"
                        fill="white" />
                </svg>
                <svg width="18" height="20" viewBox="0 0 18 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M13.75 12.5C12.8669 12.5 12.0552 12.8054 11.4145 13.3162L7.41109 10.8141C7.52965 10.2778 7.52965 9.72213 7.41109 9.18586L11.4145 6.68375C12.0552 7.19457 12.8669 7.5 13.75 7.5C15.8211 7.5 17.5 5.82105 17.5 3.75C17.5 1.67895 15.8211 0 13.75 0C11.6789 0 10 1.67895 10 3.75C10 4.02961 10.0309 4.30195 10.0889 4.5641L6.08555 7.06621C5.4448 6.55543 4.63312 6.25 3.75 6.25C1.67895 6.25 0 7.92895 0 10C0 12.0711 1.67895 13.75 3.75 13.75C4.63312 13.75 5.4448 13.4446 6.08555 12.9338L10.0889 15.4359C10.0297 15.7032 9.99992 15.9762 10 16.25C10 18.3211 11.6789 20 13.75 20C15.8211 20 17.5 18.3211 17.5 16.25C17.5 14.1789 15.8211 12.5 13.75 12.5Z"
                        fill="white" />
                </svg>
                <svg width="18" height="20" viewBox="0 0 18 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M8.75 10C11.5117 10 13.75 7.76172 13.75 5C13.75 2.23828 11.5117 0 8.75 0C5.98828 0 3.75 2.23828 3.75 5C3.75 7.76172 5.98828 10 8.75 10ZM12.25 11.25H11.5977C10.7305 11.6484 9.76562 11.875 8.75 11.875C7.73438 11.875 6.77344 11.6484 5.90234 11.25H5.25C2.35156 11.25 0 13.6016 0 16.5V18.125C0 19.1602 0.839844 20 1.875 20H15.625C16.6602 20 17.5 19.1602 17.5 18.125V16.5C17.5 13.6016 15.1484 11.25 12.25 11.25Z"
                        fill="white" />
                </svg>
                <svg width="23" height="20" viewBox="0 0 23 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M20.6297 11.7703L22.4763 3.64527C22.6096 3.05863 22.1637 2.5 21.5621 2.5H6.21906L5.86102 0.749609C5.7718 0.31332 5.38789 0 4.94254 0H0.9375C0.419727 0 0 0.419727 0 0.9375V1.5625C0 2.08027 0.419727 2.5 0.9375 2.5H3.6673L6.41137 15.9154C5.75488 16.293 5.3125 17.0009 5.3125 17.8125C5.3125 19.0206 6.29187 20 7.5 20C8.70813 20 9.6875 19.0206 9.6875 17.8125C9.6875 17.2002 9.43566 16.6471 9.03031 16.25H17.2196C16.8143 16.6471 16.5625 17.2002 16.5625 17.8125C16.5625 19.0206 17.5419 20 18.75 20C19.9581 20 20.9375 19.0206 20.9375 17.8125C20.9375 16.9464 20.4341 16.198 19.7039 15.8436L19.9195 14.8953C20.0528 14.3086 19.6069 13.75 19.0053 13.75H8.5202L8.26453 12.5H19.7155C20.1532 12.5 20.5327 12.1971 20.6297 11.7703Z"
                        fill="white" />
                </svg>
            </div>

        </div>
        <div id="img_search">
        <a href="index.php"><img src="vinyles-artistes\best-music.png" alt="Logo BestMusic"></a>
            <input type="text" placeholder="&#xF002;Rechercher un artiste,un titre...">

        </div>
        <nav id="nav_desktop">
            <ul>
                <li>
                    <a href="selections.php">Nos Sélections</a> <i class="fa-solid fa-caret-down"></i>
                    <ul>
                        <li><a href="#">Sous-item 1</a></li>
                        <li><a href="#">Sous-item 2</a></li>
                        <li><a href="#">Sous-item 3</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Genre Musicaux</a> <i class="fa-solid fa-caret-down"></i>
                    <ul>
                        <li><a href="#">Sous-item 1</a></li>
                        <li><a href="#">Sous-item 2</a></li>
                        <li><a href="#">Sous-item 3</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Nos Actualités</a>
                </li>
                <li>
                    <a href="#">Notre Blog</a>
                </li>
            </ul>
        </nav>
    </header>